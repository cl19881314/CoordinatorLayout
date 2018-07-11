package com.example.playuitest

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    var mImgZhangdan: ImageView? = null
    var mImgZhangdanTxt: TextView? = null
    var toolbar1: View? = null
    var toolbar2: View? = null
    var mJiahao: ImageView? = null
    var mTongxunlu: ImageView? = null
    var mImgShaomiao: ImageView? = null
    var mImgFukuang: ImageView? = null
    var mImgSearch: ImageView? = null
    var mImgZhaoxiang: ImageView? = null
    var mAppBarLayout: AppBarLayout? = null
    var mRv: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        mRv!!.layoutManager = LinearLayoutManager(this)
        mRv!!.adapter = LifeAdapter(this)
        mAppBarLayout!!.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            //                System.out.println("verticalOffset = [" + verticalOffset + "]" + "{" + Math.abs(verticalOffset) + "}" + "{:" + appBarLayout.getTotalScrollRange() + "}");
            if (verticalOffset == 0) {
                //完全展开
                toolbar1!!.visibility = View.VISIBLE
                toolbar2!!.visibility = View.GONE
                setToolbar1Alpha(255)
            } else if (Math.abs(verticalOffset) == appBarLayout.totalScrollRange) {
                //appBarLayout.getTotalScrollRange() == 200
                //完全折叠
                toolbar1!!.visibility = View.GONE
                toolbar2!!.visibility = View.VISIBLE
                setToolbar2Alpha(255)
            } else {//0~200上滑下滑
                if (toolbar1!!.visibility === View.VISIBLE) {
                    //                        //操作Toolbar1
                    val alpha = 300 - 155 - Math.abs(verticalOffset)
                    Log.i("alpha:", alpha.toString() + "")
                    setToolbar1Alpha(alpha)

                } else if (toolbar2!!.visibility === View.VISIBLE) {
                    if (Math.abs(verticalOffset) > 0 && Math.abs(verticalOffset) < 200) {
                        toolbar1!!.visibility = View.VISIBLE
                        toolbar2!!.visibility = View.GONE
                        setToolbar1Alpha(255)
                    }
                    //                        //操作Toolbar2
                    val alpha = (255 * (Math.abs(verticalOffset) / 100f)).toInt()
                    setToolbar2Alpha(alpha)
                }
            }

           /* //垂直方向偏移量
            var offset = Math.abs(verticalOffset)
            //最大偏移距离
            var scrollRange = appBarLayout.totalScrollRange
            if (offset <= scrollRange / 2) {//当滑动没超过一半，展开状态下toolbar显示内容，根据收缩位置，改变透明值
                toolbar1!!.visibility = View.VISIBLE
                toolbar2!!.visibility = View.GONE
                //根据偏移百分比 计算透明值
                var scale2 = offset.toFloat()  / (scrollRange / 2)
                var alpha2 =  (255 * scale2).toInt()
                toolbar1!!.setBackgroundColor(Color.argb(alpha2, 25, 131, 209))
            } else {//当滑动超过一半，收缩状态下toolbar显示内容，根据收缩位置，改变透明值

                toolbar1!!.visibility = View.GONE
                toolbar2!!.visibility = View.VISIBLE
                var scale3 = (scrollRange  - offset ).toFloat() / (scrollRange / 2)
                var alpha3 =  (255 * scale3).toInt()
                toolbar2!!.setBackgroundColor(Color.argb(alpha3, 25, 131, 209))
            }
            //根据偏移百分比计算扫一扫布局的透明度值
            var scale = offset.toFloat()  / scrollRange
            var alpha = (255 * scale).toInt()
            bgContent.setBackgroundColor(Color.argb(alpha, 25, 131, 209))
*/
        })
    }

    private fun initView() {
        mImgZhangdan = findViewById(R.id.img_zhangdan)
        mImgZhangdanTxt = findViewById(R.id.img_zhangdan_txt)
        toolbar1 = findViewById(R.id.toolbar1)
        toolbar2 = findViewById(R.id.toolbar2)
        mJiahao = findViewById(R.id.jiahao)
        mTongxunlu = findViewById(R.id.tongxunlu)
        mImgShaomiao = findViewById(R.id.img_shaomiao)
        mImgFukuang = findViewById(R.id.img_fukuang)
        mImgSearch = findViewById(R.id.img_search)
        mImgZhaoxiang = findViewById(R.id.img_zhaoxiang)
        mAppBarLayout = findViewById(R.id.appBarLayout)
        mRv = findViewById(R.id.rv)
    }


    fun setToolbar1Alpha(alpha: Int) {
        mImgZhangdan!!.drawable.alpha = alpha
        mImgZhangdanTxt!!.setTextColor(Color.argb(alpha, 255, 255, 255))
        mTongxunlu!!.drawable.alpha = alpha
        mJiahao!!.drawable.alpha = alpha
    }

    fun setToolbar2Alpha(alpha: Int) {
        mImgShaomiao!!.drawable.alpha = alpha
        mImgFukuang!!.drawable.alpha = alpha
        mImgSearch!!.drawable.alpha = alpha
        mImgZhaoxiang!!.drawable.alpha = alpha
    }

}
