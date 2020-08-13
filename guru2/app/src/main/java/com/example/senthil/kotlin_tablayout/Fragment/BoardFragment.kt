package com.example.senthil.kotlin_tablayout.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.senthil.kotlin_tablayout.R
import com.example.senthil.kotlin_tablayout.WriteActivity.BoardWrite
import com.example.senthil.kotlin_tablayout.WriteActivity.DiaryWrite
import kotlinx.android.synthetic.main.fragment_board.*
import kotlinx.android.synthetic.main.fragment_diary.*

class BoardFragment : Fragment() {

    val memos = ArrayList<String>()//메모를 저장할 배열

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAdd_board.setOnClickListener {
            activity?.let {
                val intent = Intent(context, BoardWrite::class.java)
                startActivity(intent) //메모추가 누르면 메모 작성화면으로 이동
            }

        }
    }
}
