package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCatProductlistBinding


class CategoryProductsFragment : Fragment() {

    private var _binding: FragmentCatProductlistBinding? = null
    private val binding get() = _binding!!

    private lateinit var category: String
    private lateinit var products: List<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString("category") ?: "Unknown"

        // Mockup รายการสินค้าในแต่ละหมวดหมู่
        products = when (category) {
            "Mouse" -> listOf(
                Model("Ninjutso Sora v1", "2800฿", R.mipmap.ic_sora),
                Model("Ninjutso Sora v2", "3900฿", R.mipmap.ic_sora),
                Model("Ninjutso Sora 4000k", "3500฿", R.mipmap.ic_sora)
            )
            "Keyboard" -> listOf(
                Model("Wooting 60he", "7990฿", R.mipmap.ic_wooting),
                Model("Wooting 60he", "7990฿", R.mipmap.ic_wooting)
            )
            "Headset" -> listOf(
                Model("HyperX Cloud III", "3100฿", R.mipmap.ic_cloud3),
                Model("HyperX Cloud III", "3100฿", R.mipmap.ic_cloud3)
            )
            else -> emptyList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatProductlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoryTitle.text = category
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewProducts.adapter = Prod(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
