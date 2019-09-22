package cc.captaincode.hurrileaf.activities.paymentDonation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.paymentDonation.viewModel.PaymentDonationViewModel
import cc.captaincode.hurrileaf.data.PaymentModel

import kotlinx.android.synthetic.main.activity_payment_donation.*

class PaymentDonationActivity : AppCompatActivity() {

    lateinit var paymentDonationViewModel: PaymentDonationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_donation)

        var value = intent.extras?.getString("resourceCategory")!!
        tvCategoryLabel.text = value.capitalize()
        paymentDonationViewModel = PaymentDonationViewModel(this)

        btnConfirmPayment.setOnClickListener {
            savePaymentInfo()
        }

    }

    fun savePaymentInfo() {
        paymentDonationViewModel.savePaymentInfo(
            PaymentModel(
                Integer.parseInt(etPaymentAmount.text.toString()).toDouble(),
                tvCategoryLabel.text.toString(),
                etCardHolder.text.toString()
            )
        )

    }

}
