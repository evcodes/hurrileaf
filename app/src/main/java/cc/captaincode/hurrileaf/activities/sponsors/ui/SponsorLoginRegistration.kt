package cc.captaincode.hurrileaf.activities.sponsors.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.sponsors.viewModel.SponsorLoginViewModel
import cc.captaincode.hurrileaf.coordinators.SponsorCoordinator
import kotlinx.android.synthetic.main.activity_sponsor_login_registration.*

class SponsorLoginRegistration : AppCompatActivity() {
    var sponsorCoordinator = SponsorCoordinator(this)

    lateinit var sponsorLoginViewModel: SponsorLoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_login_registration)

        sponsorLoginViewModel = SponsorLoginViewModel(this)
        btnRegister.setOnClickListener { registerSponsor() }
        btnLogin.setOnClickListener { loginSponsor() }
    }

    private fun registerSponsor(){
        sponsorCoordinator.startRegistrationActivity()
    }
    private fun loginSponsor(){
        sponsorLoginViewModel.login(etLoginEmail.text.toString(),etLoginPassword.text.toString())
    }
}
