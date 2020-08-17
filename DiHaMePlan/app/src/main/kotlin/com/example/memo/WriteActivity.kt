package com.example.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val intentGoMain = Intent(this, MainActivity::class.java) // 메인 액티비티로 돌아가는 인텐트 생성

        time.setIs24HourView(true)

        time.setOnTimeChangedListener { view, hourOfDay, minute ->
            //clock.text = "$hourOfDay : $minute"

            val editText: EditText = findViewById(R.id.editTxtMemo)
            editText.setText("$hourOfDay : $minute ▶")

        }

        btnSave.setOnClickListener { // 저장 버튼을 눌렀을 때
            if (editTxtMemo.text.toString() == "") { // EditText가 비어있다면
                Toast.makeText(this, "저장할 내용이 없습니다.", Toast.LENGTH_SHORT).show() // 안내 문구 출력
            } else {
                intentGoMain.putExtra("newMemo", editTxtMemo.text.toString()) // 인텐트에 editText에 있는 내용 저장
                setResult(Activity.RESULT_OK, intentGoMain) // 정상 실행 되었다는 뜻으로 RESULT_OK 설정
                Toast.makeText(this, "메모가 저장되었습니다.", Toast.LENGTH_SHORT).show() // 문구 출력
                finish() // 돌아가기
            }
        }
    }
}