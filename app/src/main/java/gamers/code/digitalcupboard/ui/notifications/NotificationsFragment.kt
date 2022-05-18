package gamers.code.digitalcupboard.ui.notifications

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gamers.code.digitalcupboard.MainActivity
import gamers.code.digitalcupboard.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root

    }

    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)!!.navView.isVisible = true
    }
    override fun onResume() {
        super.onResume()
        (activity as MainActivity?)!!.navView.isVisible = true
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}