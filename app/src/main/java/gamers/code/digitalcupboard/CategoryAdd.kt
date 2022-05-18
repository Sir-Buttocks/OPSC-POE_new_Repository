package gamers.code.digitalcupboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import gamers.code.digitalcupboard.databinding.FragmentCategoryAddBinding
import gamers.code.digitalcupboard.databinding.FragmentHomeBinding
import com.google.firebase.storage.StorageReference as StorageReference1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryAdd.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryAdd : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentCategoryAddBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryAddBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.btnAddCategory.setOnClickListener{addCategory()}

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryAdd.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryAdd().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun addCategory(){

    }

    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)!!.navView.isVisible = false
    }
    override fun onResume() {
        super.onResume()
        (activity as MainActivity?)!!.navView.isVisible = false
    }
}