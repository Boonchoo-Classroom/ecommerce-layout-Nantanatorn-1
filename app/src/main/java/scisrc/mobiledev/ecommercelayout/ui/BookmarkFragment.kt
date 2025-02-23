package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentBookmark2Binding

class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmark2Binding? = null
    private val binding get() = _binding!!

    private val favoriteProducts = listOf(
        Model("Ninjutso Sora", "2999฿", R.mipmap.ic_sora),
        Model("Ninjutso Sora v2", "3500฿", R.mipmap.ic_sora),
        Model("Ninjutso Sora 4k", "3100฿", R.mipmap.ic_sora),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmark2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFavorites.adapter = Prod(favoriteProducts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
