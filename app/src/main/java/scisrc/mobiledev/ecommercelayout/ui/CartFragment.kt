package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCart2Binding

class CartFragment : Fragment() {

    private var _binding: FragmentCart2Binding? = null
    private val binding get() = _binding!!

    // Mockup สินค้าในตะกร้า
    private val cartProducts = listOf(
        Model("Wooting 60he", "7990฿", R.mipmap.ic_wooting),
        Model("Ninjutso Sora v2", "3500฿", R.mipmap.ic_sora),
        Model("HyperX Cloud III", "3100฿", R.mipmap.ic_cloud3),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCart2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ตั้งค่า RecyclerView
        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCart.adapter = Prod(cartProducts)

        // คำนวณราคารวม
        val totalPrice = cartProducts.sumOf { it.price.replace("฿", "").toInt() }
        binding.cartTotalPrice.text = "รวม: ${totalPrice}฿"

        // ปุ่มชำระเงิน
        binding.btnCheckout.setOnClickListener {
            // TODO: ทำให้ไปหน้า Checkout (ตอนนี้ยังไม่ต้องมีฟังก์ชันจริง)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
