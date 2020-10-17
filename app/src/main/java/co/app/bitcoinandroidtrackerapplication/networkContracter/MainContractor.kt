package co.app.bitcoinandroidtrackerapplication.networkContracter

import android.content.Context
import co.app.bitcoinandroidtrackerapplication.constants.ApiConstants

interface MainContractor {
    interface View{
        fun setViewData(data:String,view: ApiConstants)
    }
    // for network calling..
    interface Presenter {
        fun onClick(caseConstants: ApiConstants, parameters: Array<String>, context: Context, showProgressBar: Boolean?)
    }
}