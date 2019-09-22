package cc.captaincode.hurrileaf.activities.sponsors.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.sponsors.viewModel.SponsorRegistrationViewModel
import cc.captaincode.hurrileaf.data.Sponsor
import kotlinx.android.synthetic.main.activity_sponsor_registration.*

lateinit var sponsorRegistrationViewModel: SponsorRegistrationViewModel

class SponsorRegistration: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_registration)
        sponsorRegistrationViewModel = SponsorRegistrationViewModel(this)

        btnSavePreferences.setOnClickListener { setSponsorInfo() }
    }


    fun checkUserInput(){

    }
    fun setSponsorInfo() {
        Log.d("btn_clicked", "Word")
        var username = etSponsorName.text.toString()
        var userBudget = Integer.parseInt(etBudgetAmt.text.toString())
        var userEmail = etSponsorEmail.text.toString()
        var userPassword = etSponsorPassword.text.toString()
        var userWaterAmt = sbWater.progress
        var userMedicineAmt = sbMedicine.progress
        var userFoodAmt = sbFood.progress
        var userClothesAmt = sbClothes.progress
        var userConstructionMaterials = sbMaterials.progress

        sponsorRegistrationViewModel.registerUser(
            Sponsor(
                "",
                username,
                userBudget,
                userEmail,
                userPassword,
                userWaterAmt,
                userMedicineAmt,
                userFoodAmt,
                userClothesAmt,
                userConstructionMaterials
            )
        )
    }
}
