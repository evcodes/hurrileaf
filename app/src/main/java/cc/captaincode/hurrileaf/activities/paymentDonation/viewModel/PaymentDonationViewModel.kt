package cc.captaincode.hurrileaf.activities.paymentDonation.viewModel

import android.widget.Toast
import cc.captaincode.hurrileaf.activities.paymentDonation.ui.PaymentDonationActivity
import cc.captaincode.hurrileaf.data.PaymentModel

import com.google.firebase.firestore.FirebaseFirestore

class PaymentDonationViewModel (var paymentDonation: PaymentDonationActivity){

    fun savePaymentInfo(payment: PaymentModel){
        FirebaseFirestore.getInstance().collection("paymentInfo").add(payment).addOnSuccessListener {
            Toast.makeText(paymentDonation,"Payment sent",Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(paymentDonation, "Payment unsuccessful", Toast.LENGTH_LONG).show()
        }
    }
}
