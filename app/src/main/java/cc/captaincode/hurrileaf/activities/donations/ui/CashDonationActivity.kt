package cc.captaincode.hurrileaf.activities.donations.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.coordinators.CashDonationCoordinator
import kotlinx.android.synthetic.main.activity_cash_donation.*


class CashDonationActivity : AppCompatActivity() {

    lateinit var cashDonationCoordinator: CashDonationCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_donation)

        cashDonationCoordinator= CashDonationCoordinator(this)

        imgBtnWater.setOnClickListener{startPaymentDetail("water")}
        imgBtnFood.setOnClickListener{startPaymentDetail("food")}
        imgBtnMaterials.setOnClickListener{startPaymentDetail("materials")}
        imgBtnMedicine.setOnClickListener{startPaymentDetail("medicine")}
        imgBtnClothes.setOnClickListener{startPaymentDetail("clothes")}

    }

    fun startPaymentDetail(resource:String){
        cashDonationCoordinator.startCashDonation(resource)
    }
}

