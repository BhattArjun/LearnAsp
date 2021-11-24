package arjun.mca.learnaspnet

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.CardView
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AspTutorial.newInstance] factory method to
 * create an instance of this fragment.
 */
class AspTutorial : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_asp_tutorial, container, false)

        var c1 = v.findViewById<CardView>(R.id.cv1)
        var c2 = v.findViewById<CardView>(R.id.cv2)
        var c3 = v.findViewById<CardView>(R.id.cv3)
        var c4 = v.findViewById<CardView>(R.id.cv4)
        var c5 = v.findViewById<CardView>(R.id.cv5)
        var c6 = v.findViewById<CardView>(R.id.cv6)

        c1.setOnClickListener {
            var intent = Intent(requireContext() , BasicTutorial::class.java)
            startActivity(intent)
        }
        c2.setOnClickListener {
            var intent = Intent(requireContext() , AdvancedTutorial::class.java)
            startActivity(intent)
        }
        c3.setOnClickListener {
            var intent = Intent(requireContext() , Aspvalidation::class.java)
            startActivity(intent)
        }
        c4.setOnClickListener {
            var intent = Intent(requireContext() , AspWithMVC::class.java)
            startActivity(intent)
        }
        c5.setOnClickListener {
            var intent = Intent(requireContext() , InterviewQustions::class.java)
            startActivity(intent)
        }
        c6.setOnClickListener {
            var intent = Intent(requireContext() , Material::class.java)
            startActivity(intent)
        }



        return  v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AspTutorial.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AspTutorial().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}