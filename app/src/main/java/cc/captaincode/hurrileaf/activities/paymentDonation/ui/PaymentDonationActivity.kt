package cc.captaincode.hurrileaf.activities.paymentDonation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.captaincode.hurrileaf.R
import kotlinx.android.synthetic.main.activity_payment_donation.*

class PaymentDonationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_donation)

        var value = intent.extras?.getString("resourceCategory")!!
        tvCategoryLabel.text = value.capitalize()
    }
}
