package com.ytfu.lawyercircle.ui.users.act

import android.content.Context
import android.content.Intent
import com.core.ui.activity.BaseEmptyActivity
import com.github.lee.annotation.InjectLayout
import com.ytfu.lawyercircle.R
import com.ytfu.lawyercircle.ui.users.fragment.SkillsFragmentList
import extension.color
import qiu.niorgai.StatusBarCompat

/**
 * @Author:         gxy
 * @CreateDate:     2020/9/17
 * @Description:     使用技巧列表
 */
@InjectLayout(toolbarLayoutId = R.layout.layout_toolbar_center_title)
class SkillsActivityList : BaseEmptyActivity() {
    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SkillsActivityList::class.java)
            context.startActivity(starter)
        }
    }

    override fun onSetViewData() {
        super.onSetViewData()
        StatusBarCompat.setStatusBarColor(this, resources.color(R.color.white))
        changeStatusBarTextColor(true)
        setToolbarBackgroundColor(resources.color(R.color.white))
        setToolbarLeftImage(R.drawable.fanhui_hui) { onBackPressed() }
        setToolbarTextColor(R.id.tv_global_title, resources.color(R.color.textColor_33))
        setToolbarText(R.id.tv_global_title, "使用技巧")
        val skillsFragmentList = SkillsFragmentList.newInstance()
        replaceFragment(skillsFragmentList)
    }

}