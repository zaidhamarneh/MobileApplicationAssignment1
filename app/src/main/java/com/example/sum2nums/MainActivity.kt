package com.example.sum2nums
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.Result)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val resultTV: TextView = findViewById(R.id.textresult)
        var flag:String="sum"
        val spinnerVal:Spinner=findViewById(R.id.spselect)
        var options = arrayOf("Euro","dollar")
        spinnerVal.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,options)
        spinnerVal.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag=options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        button.setOnClickListener{ view ->
            var x: Float = edtxt1.text.toString().toFloat();

            if(flag =="Euro")
                resultTV.text = euro(x).toString();
            else
                resultTV.text = dollar(x).toString();
        }
    }
}
public fun euro(a: Float): Double {
    return a*1.32;
}
public fun dollar(a: Float): Double {
    return a*1.41;
}

