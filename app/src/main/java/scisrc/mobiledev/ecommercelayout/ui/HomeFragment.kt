package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val recommendedProducts = listOf(
        Model("Wooting 60he", "7990฿", R.mipmap.ic_wooting),
        Model("Ninjutso Sora v2", "3500฿", R.mipmap.ic_sora),
        Model("HyperX Cloud III", "3100฿", R.mipmap.ic_cloud3),
    )

    private val promotions = listOf(
        Model("Buy 1 Mouse free 1 Headset", "Limited 3 order!", R.mipmap.ic_cloud3)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bannerImage.setImageResource(R.drawable.ic_home)

        binding.recyclerViewRecommended.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewRecommended.adapter = Prod(recommendedProducts)

        binding.recyclerViewPromotions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPromotions.adapter = Prod(promotions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
