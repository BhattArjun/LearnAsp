package arjun.mca.learnaspnet

import android.app.FragmentTransaction
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AspCreateNotes.newInstance] factory method to
 * create an instance of this fragment.
 */

class AspCreateNotes : Fragment() {
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
    ):View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_asp_create_notes, container, false)


        var helper = MyDBHelper(requireContext())
        var db = helper.readableDatabase

        var edtitile = v.findViewById<EditText>(R.id.edTitle)
        var ednote = v.findViewById<EditText>(R.id.edmtv)

        var rs = db.rawQuery("SELECT * FROM USERDATA", null)
        var btn = v.findViewById<Button>(R.id.button)
        var lv = v.findViewById<ListView>(R.id.AspNote_lv)

        var from = arrayOf("TITLE", "NOTE")
        var to = intArrayOf(android.R.id.text1, android.R.id.text2)


        var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, from)

        btn.setOnClickListener {

            var cv = ContentValues()
            cv.put("TITLE", edtitile.text.toString())
            cv.put("NOTE", ednote.text.toString())
            db.insert("USERDATA", null, cv)

            edtitile.setText("")
            ednote.setText("")
            Toast.makeText(requireContext(), "Your Recoed is Added..!", Toast.LENGTH_LONG).show()
            //db.rawQuery("SELECT _id,TITLE, NOTE FROM USERDATA",null)
            edtitile.requestFocus()

        //db.rawQuery("SELECT _id,TITLE, NOTE FROM USERDATA",null)

        }

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AspCreateNotes.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AspCreateNotes().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}