package cc.captaincode.hurrileaf.activities.sponsors.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.sponsors.viewModel.SponsorRegistrationViewModel
import cc.captaincode.hurrileaf.coordinators.SponsorCoordinator
import cc.captaincode.hurrileaf.data.Sponsor
import kotlinx.android.synthetic.main.activity_sponsor_registration.*

class SponsorRegistration : AppCompatActivity() {

    lateinit var sponsorRegistrationViewModel: SponsorRegistrationViewModel
    lateinit var sponsorCoordinator: SponsorCoordinator

    var budget = 10
    var cur_points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_registration)

        sponsorCoordinator = SponsorCoordinator(this)
        sponsorRegistrationViewModel = SponsorRegistrationViewModel(this)

        tvBudget.text = tvBudget.text.toString() + budget.toString()
        updateButton()
        btnSavePreferences.setOnClickListener { savePreferences() }

        sbMedicine.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) { }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {updateBudget(p0!!)}
        })
        sbWater.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {  }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {updateBudget(p0!!)}
        })
        sbMaterials.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) { }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {updateBudget(p0!!)}
        })
        sbFood.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {  }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {updateBudget(p0!!)}
        })
        sbClothes.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) { }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {updateBudget(p0!!)}
        })
    }

    fun updateButton(){
        if (budget > 0){
            btnSavePreferences.setBackgroundColor(resources.getColor(R.color.common_google_signin_btn_text_dark_disabled))
            btnSavePreferences.isEnabled = false
        }else if (budget == 0){
            btnSavePreferences.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            btnSavePreferences.isEnabled = true
        }
    }

    fun calc_points(){
        cur_points = sbClothes.progress + sbFood.progress + sbMaterials.progress + sbWater.progress + sbMedicine.progress
    }

    fun updateBudget(p0:SeekBar){
        calc_points()

        if (p0.progress <= budget && cur_points <= 10){
            budget = 10 - cur_points
            tvBudget.text = "Budget: ${budget}"
            updateButton()
        }else{
            p0.progress = 0

            budget = 10 - cur_points
            calc_points()
        }
    }

    fun checkAgreement() {
        sponsorCoordinator.startTermsOfService()
    }

    private fun checkEmailField(et: EditText): Boolean {
        return !TextUtils.isEmpty(et.text.toString()) && Patterns.EMAIL_ADDRESS.matcher(et.text.toString()).matches()
    }

    private fun checkEmptyFields(et: EditText): Boolean {
        return !TextUtils.isEmpty(et.text.toString())
    }

    fun initRegistration() {
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

        sponsorRegistrationViewModel.registerUser(newSponsor)
    }

    fun savePreferences() {

        if (!checkEmailField(etSponsorEmail)) {
            Toast.makeText(this, "Email format is incorrect", Toast.LENGTH_LONG).show()
        } else if (!checkEmptyFields(etSponsorPassword)) {
            Toast.makeText(this, "Password is empty", Toast.LENGTH_LONG).show()
        } else if (!checkEmptyFields(etBudgetAmt) || Integer.parseInt(etBudgetAmt.text.toString()) == 0) {
            Toast.makeText(this, "Budget cannot be empty or 0", Toast.LENGTH_LONG).show()
        } else if (!checkEmptyFields(etSponsorName) || Integer.parseInt(etBudgetAmt.text.toString()) == 0) {
            Toast.makeText(this, "Must enter a sponsor name", Toast.LENGTH_LONG).show()
        } else {
            initRegistration()
            checkAgreement()
        }
    }
}
