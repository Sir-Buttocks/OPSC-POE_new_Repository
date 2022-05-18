package gamers.code.digitalcupboard.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import gamers.code.digitalcupboard.MainActivity
import gamers.code.digitalcupboard.R
import gamers.code.digitalcupboard.data.ListAdapterCatagoriesRV
import gamers.code.digitalcupboard.data.model.CategoriesModel
import gamers.code.digitalcupboard.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlin.random.Random

class DashboardFragment : Fragment(), ListAdapterCatagoriesRV.Interaction  {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
     lateinit var categoryListAdapter : ListAdapterCatagoriesRV

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()


        root.btnCategory.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_dashboard_to_categoryAdd)
        }

        return root
    }
    fun initRecyclerView(){
        val recycler_view = binding.recyclerView
        recycler_view.apply{
            layoutManager = LinearLayoutManager(activity)
            categoryListAdapter = ListAdapterCatagoriesRV(this@DashboardFragment)
            adapter = categoryListAdapter

        }
        val list = mutableListOf(
            CategoriesModel(0,"Calvin","Shirt",7, Random.nextInt(7)),
            CategoriesModel(1,"Calvin","Pants",7,Random.nextInt(7)),
            CategoriesModel(2,"Calvin","Socks",7,Random.nextInt(7)),
            CategoriesModel(3,"Calvin","Shoes",7,Random.nextInt(7)),
            CategoriesModel(0,"Michael","Shirt",7,Random.nextInt(7)),
            CategoriesModel(1,"Michael","Pants",7,Random.nextInt(7)),
            CategoriesModel(2,"Michael","Socks",7,Random.nextInt(7)),
            CategoriesModel(3,"Michael","Shoes",7,Random.nextInt(7)),
            CategoriesModel(0,"Ruan","Shirt",7,Random.nextInt(7)),
            CategoriesModel(1,"Ruan","Pants",7,Random.nextInt(7)),
            CategoriesModel(2,"Ruan","Socks",7,Random.nextInt(7)),
            CategoriesModel(3,"Ruan","Shoes",7,Random.nextInt(7)),
            CategoriesModel(0,"Ruben","Shirt",7,Random.nextInt(7)),
            CategoriesModel(1,"Ruben","Pants",7,Random.nextInt(7)),
            CategoriesModel(2,"Ruben","Socks",7,Random.nextInt(7)),
            CategoriesModel(3,"Ruben","Shoes",7,Random.nextInt(7)),
            CategoriesModel(0,"Monty","Shirt",7,Random.nextInt(7)),
            CategoriesModel(1,"Monty","Pants",7,Random.nextInt(7)),
            CategoriesModel(2,"Monty","Socks",7,Random.nextInt(7)),
            CategoriesModel(3,"Monty","Shoes",7,Random.nextInt(7)),
        )
        list.sort()
        categoryListAdapter.submitList(list)
    }
    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)!!.navView.isVisible = true
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(position: Int, item: CategoriesModel) {
        binding.root.findNavController().navigate(R.id.action_navigation_dashboard_to_itemCollectionFragment)
    }
}