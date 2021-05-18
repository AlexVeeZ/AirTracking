package com.example.airtracking

/*Основные:
1. Привести список в адекватное состояние (+)
2. Повесить clickListener на элементы списка
3. Создать интенты

Второстепенные
1. Иконка приложения (+)
2. Убрать верхний заголовок приложения (+)
3. Запретить горизонтальный вид (+)
4. *Сделать фрагмент с заставкой при активации приложения*/

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airtracking.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), RVAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exampleList = generateAirlineList(20)
        binding.rvOfAirline.adapter = RVAdapter(exampleList, this)

        binding.rvOfAirline.layoutManager = LinearLayoutManager(this)
        binding.rvOfAirline.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        if (position == 0) run {newIntent(Constants.MOSCOW_CARGO)}
        if (position == 1) run {newIntent(Constants.SHEREMETYEVO_CARGO)}
        if (position == 2) run {newIntent(Constants.DOMODEDOVO_CARGO)}
        if (position == 3) run {newIntent(Constants.VNUKOVO_CARGO)}
        if (position == 4) run {newIntent(Constants.AEROFLOT_AIRLINE)}
        if (position == 5) run {newIntent(Constants.AIRBRIDGECARGO)}
        if (position == 6) run {newIntent(Constants.SWISS_AIRLINE)}
        if (position == 7) run {newIntent(Constants.TURKISH_AIRLINE)}
        if (position == 8) run {newIntent(Constants.EMIRATES_AIRLINE)}
    }

    fun newIntent(uriString: String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uriString)
        startActivity(intent)
    }

    private fun generateAirlineList(size: Int): List<AirlineItem>{
        val list = ArrayList<AirlineItem>()
        for (i in 0 until size) {
            val drawable = when (i % size) {
                0 -> R.drawable.moscowcargo
                1 -> R.drawable.sheremetievocargo
                2 -> R.drawable.domodedovocargo
                3 -> R.drawable.vnukovocargo
                4 -> R.drawable.aeroflot
                5 -> R.drawable.airbridgecargo
                6 -> R.drawable.swiss
                7 -> R.drawable.turkish
                8 -> R.drawable.emirates
                else -> break
            }

            var string: String? = null
            if(i == 0){string = getText(R.string.moscow_cargo).toString()}
            if(i == 1){string = getText(R.string.sheremetievo_cargo).toString()}
            if(i == 2){string = getText(R.string.domodedovo_cargo).toString()}
            if(i == 3){string = getText(R.string.vnukovo_cargo).toString()}
            if(i == 4){string = getText(R.string.aeroflot_airlines).toString()}
            if(i == 5){string = getText(R.string.airbridge_cargo).toString()}
            if(i == 6){string = getText(R.string.swiss_airlines).toString()}
            if(i == 7){string = getText(R.string.turkish_airlines).toString()}
            if(i == 8){string = getText(R.string.emirates_airlines).toString()}

            val item = AirlineItem(drawable, string.toString())
            list += item
        }
        return list
    }


}