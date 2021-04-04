package com.example.mynfc

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var nfcAdapter: NfcAdapter? = null
    private var pendingIntent: PendingIntent? = null
    private val tagDesc: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        val intent = Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


        val startBtn = findViewById<View>(R.id.btn1);
        val textView = findViewById<TextView>(R.id.textView);

//        val startBtn = findViewById<android.view.View>(R.id.startBtn) as Button
        startBtn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()
                textView.setBackgroundColor(Color.rgb(0,255,0))
                textView.setTextColor(Color.rgb(0,0,0))
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if (nfcAdapter != null) {
            nfcAdapter!!.enableForegroundDispatch(this, pendingIntent, null, null)
        }
    }


    override fun onPause() {
        if (nfcAdapter != null) {
            nfcAdapter!!.disableForegroundDispatch(this)
        }
        super.onPause()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val tag: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
//        val tag: Tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
        if (tag != null) {
            val tagId: ByteArray = tag.getId()
            tagDesc?.text = "TagID: "
//            tagDesc!!.text = "TagID: " + toHexString(tagId)
            val toastStr = "TagID: " + toHexString(tagId)
//            tagDesc!!.text = "TagID: " + (tagId)
//            Toast.makeText(applicationContext, "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()
            Toast.makeText(applicationContext, toastStr, Toast.LENGTH_LONG).show()


            val textView = findViewById<TextView>(R.id.textView);
            textView.setBackgroundColor(Color.rgb(255,0,0))
            textView.setTextColor(Color.rgb(255,255,255))
        }
    }


    val CHARS = "0123456789ABCDEF"


    fun toHexString(data: ByteArray): String {
        val sb = StringBuilder()
        for (i in data.indices) {
            sb.append(CHARS[(data[i].toInt() shr 4) and 0x0F]).append(CHARS[data[i].toInt() and 0x0F])
        }
        return sb.toString()
    }


}