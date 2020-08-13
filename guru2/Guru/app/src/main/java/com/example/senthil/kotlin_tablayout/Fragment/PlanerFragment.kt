package com.example.senthil.kotlin_tablayout.Fragment

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.media.MediaBrowserServiceCompat.RESULT_OK
import android.support.v4.provider.FontsContractCompat.FontRequestCallback.RESULT_OK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.senthil.kotlin_tablayout.WriteActivity.PlanerWrite

import com.example.senthil.kotlin_tablayout.R
import kotlinx.android.synthetic.main.fragment_planer.*

class PlanerFragment : Fragment() {

    val memos = ArrayList<String>()//메모를 저장할 배열

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAdd_planer.setOnClickListener {
            activity?.let {
                val intent = Intent(context, PlanerWrite::class.java)
                startActivity(intent) //메모추가 누르면 메모 작성화면으로 이동
            }

        }
    }

    //작동 안해요..ㅠㅠ
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            Activity.RESULT_OK->{
                if(data !=null){
                    memos.add(0,data.getStringExtra("newMemo"))
                }
            }
        }
    }
}

