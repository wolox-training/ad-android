package ar.com.wolox.android.example.ui.example.home

import android.content.Intent
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.example.signup.SignUpActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.fragment_home_news.*
import javax.inject.Inject

class HomeNewsFragment @Inject constructor() : WolmoFragment<BasePresenter<Any>>() {

    override fun init() {
        vHomeNewsRecyclerView.apply {
            // TODO FOR NEXT PR (Backend): change this list for data from a request to DB/API
            adapter = HomeNewsViewAdapter(listOf(News("Detuvieron a Alberto Samid en Belice",
                    "En Belice, fue detenido por Interpol Alberto Samid. Nuestra" +
                            " política es clara y transparente. Quienes tienen deudas con la" +
                            " justicia, deben"), News("Susto para Lionel Scaloni en España:" +
                    " fue atropellado por un auto y sufrió lesiones", "El DT de la " +
                    "Argentina iba en bicicleta y fue embestido en el estacionamiento del " +
                    "colegio de sus hijas. Fue atendido en un hospital y ya recibió el alta.")))
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun setListeners() {
        vHomeNewsAddButton.setOnClickListener {
            val intent = Intent(context, SignUpActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        }
    }

    override fun layout(): Int = R.layout.fragment_home_news
}
