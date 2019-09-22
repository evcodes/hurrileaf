package cc.captaincode.hurrileaf.activities.sponsors.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.sponsors.viewModel.SponsorRegistrationViewModel
import cc.captaincode.hurrileaf.coordinators.SponsorCoordinator
import cc.captaincode.hurrileaf.data.Sponsor
import kotlinx.android.synthetic.main.activity_sponsor_registration.*

class SponsorRegistration : AppCompatActivity() {

    lateinit var sponsorRegistrationViewModel: SponsorRegistrationViewModel
    lateinit var sponsorCoordinator: SponsorCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_registration)

        sponsorCoordinator = SponsorCoordinator(this)

        sponsorRegistrationViewModel = SponsorRegistrationViewModel(this)

        btnSavePreferences.setOnClickListener { savePreferences() }
    }

    fun checkAgreement() {
        sponsorCoordinator.startTermsOfService()


    }

    fun savePreferences() {


        val username = etSponsorName.text.toString()
        val password = etSponsorPassword.text.toString()
        val email = etSponsorEmail.text.toString()
        val budget = Integer.parseInt("10")
        val waterPerc = sbWater.progress
        val materialsPerc = sbMaterials.progress
        val medicinePerc = sbMedicine.progress
        val clothesPerc = sbClothes.progress
        val foodPerc = sbFood.progress

        val newSponsor = Sponsor(
            "", username,
            budget,
            email,
            password,
            waterPerc,
            medicinePerc,
            foodPerc,
            clothesPerc,
            materialsPerc
        )
        checkAgreement()

        sponsorRegistrationViewModel.registerUser(newSponsor)
    }

}
