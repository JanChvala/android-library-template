package cz.janchvala.android.kotlin.data.api

import android.content.SharedPreferences
import cz.janchvala.android.kotlin.AppScope
import cz.janchvala.android.kotlin.data.api.mock.MockGitHubService
import dagger.Module
import dagger.Provides
import retrofit.Endpoint
import retrofit.Endpoints
import retrofit.MockRestAdapter
import retrofit.RestAdapter
import retrofit.android.AndroidMockValuePersistence

@Module
public class ApiModule {

    companion object {
        @JvmStatic val PRODUCTION_API_URL: String = "https://api.github.com"
    }

    @Provides
    @AppScope
    fun provideEndpoint(): Endpoint = Endpoints.newFixedEndpoint(PRODUCTION_API_URL)

    @Provides
    @AppScope
    fun provideMockRestAdapter(restAdapter: RestAdapter,
            preferences: SharedPreferences): MockRestAdapter {
        val mockRestAdapter = MockRestAdapter.from(restAdapter)
        AndroidMockValuePersistence.install(mockRestAdapter, preferences)
        return mockRestAdapter
    }

    @Provides
    @AppScope
    fun provideGitHubService(restAdapter: MockRestAdapter): GitHubService =
            restAdapter.create(GitHubService::class.java, MockGitHubService())

}
