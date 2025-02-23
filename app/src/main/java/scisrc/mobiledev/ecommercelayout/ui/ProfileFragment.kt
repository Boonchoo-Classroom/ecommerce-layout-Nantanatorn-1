package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProfile2Binding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfile2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfile2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.profileName.text = "Nantanatorn Suetrong"
        binding.profileEmail.text = "Nantanatorns.4210@gmail.com"
        binding.profileAddress.text = "40/21 หมู่ 5 บ้านปึก ชลบุรี"


        binding.btnEditProfile.setOnClickListener {
            // TODO: เพิ่มการแก้ไขโปรไฟล์
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
