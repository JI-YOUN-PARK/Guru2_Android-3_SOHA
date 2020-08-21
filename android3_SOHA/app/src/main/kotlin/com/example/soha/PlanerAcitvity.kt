package com.example.soha

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.planer_list.*

class PlanerActivity : AppCompatActivity() {

    val memos = ArrayList<String>() // 메모를 저장할 배열

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.planer_list)

        btnBack_planer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val memos_Adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memos) // adapter 생성
        listMemos.adapter = memos_Adapter // 어댑터 붙이기
        listMemos.choiceMode = ListView.CHOICE_MODE_SINGLE // 단일 선택모드

        listMemos.setOnItemClickListener { parent, view, position, id -> // 메모 목록이 클릭되면
            Toast.makeText(this, (position + 1).toString() + "번째 메모를 클릭하셨습니다.", Toast.LENGTH_SHORT).show() // 몇 번째 메모인지 출력
        }

        btnAdd.setOnClickListener { // 메모 추가를 누르면
            val intentGoWrite = Intent(this, WriteActivity::class.java)
            startActivityForResult(intentGoWrite, 0) // 메모 작성 화면으로 이동
        }

        btnDelete.setOnClickListener { // 메모 삭제를 누르면
            val checkedItem = listMemos.checkedItemPosition // 클릭된 메모의 인덱스를 가져옴

            if(checkedItem != -1){ // 클릭한 메모가 있다면
                memos.removeAt(checkedItem) // 해당 인덱스의 메모를 삭제
                memos_Adapter.notifyDataSetChanged() // 새로고침
                listMemos.clearChoices() // 클릭된 메모를 선택 해제 시킴
                Toast.makeText(this, (checkedItem + 1).toString() + "번째 메모를 삭제했습니다.", Toast.LENGTH_SHORT).show() // 삭제 메시지 출력
            }
        }
    }

    // 메모 작성을 하고 다시 메인 화면으로 돌아왔을 때
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            Activity.RESULT_OK -> { // resultCode가 RESULT_OK 라면 (메모가 정상적으로 저장 되었다면)
                if (data != null) { // 데이터가 비어있는지 확인하고
                    memos.add(0, data.getStringExtra("newMemo").toString()) // 0번지에 메모를 저장
                }
            }

            Activity.RESULT_CANCELED -> { // resultCode가 RESULT_CANCELED 라면 (뒤로가기를 둘러서 돌아왔다면)
                Toast.makeText(this, "작성이 취소되었습니다.", Toast.LENGTH_SHORT).show() // 작성 취소 메시지 출력
            }
        }
    }
}