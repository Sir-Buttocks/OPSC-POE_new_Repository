package gamers.code.digitalcupboard


import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi


import androidx.recyclerview.widget.LinearLayoutManager
import gamers.code.digitalcupboard.data.ListAdapterItemRV
import gamers.code.digitalcupboard.data.model.Item

import gamers.code.digitalcupboard.databinding.FragmentItemCollectionBinding

import kotlinx.android.synthetic.main.fragment_item_collection.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemCollectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemCollectionFragment : Fragment() , ListAdapterItemRV.Interaction{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var itemListAdapter : ListAdapterItemRV
    private var _binding: FragmentItemCollectionBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemCollectionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()

        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun initRecyclerView(){
        val recycler_view =  binding.itemCollectionRV
        recycler_view.apply{
            layoutManager = LinearLayoutManager(activity)
            itemListAdapter = ListAdapterItemRV(this@ItemCollectionFragment)
            adapter = itemListAdapter

        }
        val list = mutableListOf(
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
            Item(0,"Favourite Shirt", java.time.LocalDate.now(),"Its the orange one"),
        )
        list.sort()
        itemListAdapter.submitList(list)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItemCollectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemCollectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemSelected(position: Int, item: Item) {

    }
}