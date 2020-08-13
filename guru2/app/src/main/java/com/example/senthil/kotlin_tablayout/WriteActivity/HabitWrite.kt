package com.example.senthil.kotlin_tablayout.WriteActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.senthil.kotlin_tablayout.R
import com.example.senthil.kotlin_tablayout.TabLayoutActivity
import kotlinx.android.synthetic.main.write_habit.*
import kotlinx.android.synthetic.main.write_planer.*
import kotlinx.android.synthetic.main.write_planer.btnSave_planer
import kotlinx.android.synthetic.main.write_planer.editTxtMemo

class HabitWrite : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_habit)

        val intentGoTabLayoutActivity = Intent(this, TabLayoutActivity::class.java)

        btnSave_habit.setOnClickListener {
            if(editTxtMemo.text.toString() == ""){ // EditText가 비어있다면
                Toast.makeText(this, "저장할 내용이 없습니다.", Toast.LENGTH_SHORT).show() // 안내 문구 출력
            }

            else{
                intentGoTabLayoutActivity.putExtra("newMemo", editTxtMemo.text.toString()) // 인텐트에 editText에 있는 내용 저장
                setResult(Activity.RESULT_OK, intentGoTabLayoutActivity) // 정상 실행 되었다는 뜻으로 RESULT_OK 설정
                Toast.makeText(this, "메모가 저장되었습니다.", Toast.LENGTH_SHORT).show() // 문구 출력
                finish() // 돌아가기
            }
        }
    }
}