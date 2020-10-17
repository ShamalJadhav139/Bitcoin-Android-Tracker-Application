package co.app.bitcoinandroidtrackerapplication.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.app.bitcoinandroidtrackerapplication.constants.ApiConstants
import co.app.bitcoinandroidtrackerapplication.databinding.FragmentHomeBinding
import co.app.bitcoinandroidtrackerapplication.model.CurrentPriceResponse
import co.app.bitcoinandroidtrackerapplication.networkContracter.MainActivityPresenter
import co.app.bitcoinandroidtrackerapplication.networkContracter.MainContractor

import com.google.gson.Gson



class HomeFragment : Fragment(), MainContractor.View {
    private var homeFragmentBinding: FragmentHomeBinding? = null
    private lateinit var presenter: MainContractor.Presenter
    private var response:CurrentPriceResponse.Bpi? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentBinding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        presenter = MainActivityPresenter(this)
        return homeFragmentBinding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        callGetCurrentPriceApi()
        homeFragmentBinding!!.usdPriceText.setOnClickListener {
            Log.d("responseeee",response.toString())
            //Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show()
            homeFragmentBinding!!.priceText.setText(response!!.USD.rate)
        }
        homeFragmentBinding!!.eurPriceText.setOnClickListener {
            homeFragmentBinding!!.priceText.setText(response!!.EUR.rate)
        }
        homeFragmentBinding!!.gbpPriceText.setOnClickListener {
            homeFragmentBinding!!.priceText.setText(response!!.GBP.rate)
        }
    }

    fun callGetCurrentPriceApi() {
        presenter.onClick(ApiConstants.currentprice, arrayOf(), context!!, true)
    }



    override fun setViewData(data: String, view: ApiConstants) {
        when (view) {
            ApiConstants.currentprice -> {
                val res = Gson().fromJson(data, CurrentPriceResponse::class.java)
                if (res != null) {
                    response = res.bpi
                    homeFragmentBinding!!.usdPriceText.setText(res.bpi.USD.code)
                    homeFragmentBinding!!.eurPriceText.setText(res.bpi.EUR.code)
                    homeFragmentBinding!!.gbpPriceText.setText(res.bpi.GBP.code)
                } else {
                    Toast.makeText(context, "Data Not Found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}