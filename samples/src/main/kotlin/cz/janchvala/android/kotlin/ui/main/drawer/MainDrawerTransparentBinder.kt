package cz.janchvala.android.kotlin.ui.main.drawer

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import cz.janchvala.android.kotlin.R
import jp.satorufujiwara.binder.recycler.RecyclerBinder

public class MainDrawerTransparentBinder(activity: Activity)
: RecyclerBinder<MainDrawerViewType>(activity, MainDrawerViewType.TRANSPARENT) {

    override fun layoutResId(): Int = R.layout.main_drawer_transparent_binder

    override fun onCreateViewHolder(view: View?): RecyclerView.ViewHolder? = ViewHolder(view)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
    }
}


