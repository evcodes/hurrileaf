package cc.captaincode.hurrileaf.activities.sponsors.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.sponsors.viewModel.SponsorRegistrationViewModel
import cc.captaincode.hurrileaf.data.Sponsor
import kotlinx.android.synthetic.main.activity_sponsor_registration.*

class SponsorRegistration : AppCompatActivity() {

    lateinit var sponsorRegistrationViewModel: SponsorRegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_registration)

        sponsorRegistrationViewModel = SponsorRegistrationViewModel(this)

        btnSavePreferences.setOnClickListener { savePreferences() }
    }

    fun savePreferences() {
        var username = etSponsorName.text.toString()
        var password = etSponsorPassword.text.toString()
        var email = etSponsorEmail.text.toString()
        var budget = Integer.parseInt("10")
        var waterPerc = sbWater.progress
        var materialsPerc = sbMaterials.progress
        var medicinePerc = sbMedicine.progress
        var clothesPerc = sbClothes.progress
        var foodPerc = sbFood.progress

        sponsorRegistrationViewModel.registerUser(
            Sponsor(
                "",
                username,
                budget,
                email,
                password,
                waterPerc,
                medicinePerc,
                foodPerc,
                clothesPerc,
                materialsPerc
            )
        )
    }

}
