package com.example.dameuncoctel.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.dameuncoctel.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AjustesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AjustesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var spinner: Spinner
    private lateinit var adapter: Adapter

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


        return inflater.inflate(R.layout.fragment_ajustes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinner = view.findViewById(R.id.spinner_idiomas)

        adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.idiomas,
            android.R.layout.simple_spinner_item)

        (adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter as ArrayAdapter<CharSequence>

        /*
        *
        * Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed ullamcorper morbi tincidunt ornare massa eget egestas purus. Amet mattis vulputate enim nulla aliquet porttitor lacus luctus. Ultrices gravida dictum fusce ut placerat. Nam libero justo laoreet sit amet cursus sit. Et molestie ac feugiat sed lectus vestibulum. Venenatis tellus in metus vulputate eu scelerisque felis imperdiet. Gravida arcu ac tortor dignissim convallis aenean et tortor at. Mattis molestie a iaculis at erat pellentesque adipiscing commodo. Eu tincidunt tortor aliquam nulla. In eu mi bibendum neque egestas congue quisque egestas. Arcu vitae elementum curabitur vitae nunc sed. Tincidunt eget nullam non nisi est sit. Lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Libero id faucibus nisl tincidunt. Volutpat diam ut venenatis tellus in metus vulputate. Viverra tellus in hac habitasse platea dictumst. Vitae sapien pellentesque habitant morbi tristique senectus.

Facilisis sed odio morbi quis commodo odio aenean sed. Sed arcu non odio euismod lacinia at. Morbi tempus iaculis urna id. Tincidunt id aliquet risus feugiat in. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim lobortis. Sit amet consectetur adipiscing elit duis. Curabitur gravida arcu ac tortor dignissim. Ut morbi tincidunt augue interdum velit euismod in. In metus vulputate eu scelerisque felis imperdiet proin fermentum. Sit amet luctus venenatis lectus magna. Sem nulla pharetra diam sit amet. Tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras fermentum. Neque viverra justo nec ultrices dui sapien eget mi proin.

Leo in vitae turpis massa. Vitae congue mauris rhoncus aenean vel elit scelerisque mauris. Gravida rutrum quisque non tellus orci ac auctor augue. Nibh praesent tristique magna sit amet. Ultricies tristique nulla aliquet enim tortor. Malesuada pellentesque elit eget gravida. Libero justo laoreet sit amet. Tellus orci ac auctor augue mauris augue neque gravida. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras. Nullam non nisi est sit amet. Nulla facilisi morbi tempus iaculis urna id volutpat lacus. Integer malesuada nunc vel risus commodo.

Quam elementum pulvinar etiam non quam lacus suspendisse. Ultrices sagittis orci a scelerisque purus semper eget duis at. Tincidunt augue interdum velit euismod. Dignissim cras tincidunt lobortis feugiat vivamus at augue. Est ante in nibh mauris cursus mattis. Amet venenatis urna cursus eget nunc scelerisque viverra mauris. Potenti nullam ac tortor vitae purus faucibus ornare. Et odio pellentesque diam volutpat commodo sed egestas. Aliquet enim tortor at auctor urna nunc id cursus. Sapien pellentesque habitant morbi tristique. Fusce id velit ut tortor pretium viverra suspendisse. Augue eget arcu dictum varius duis at. Convallis a cras semper auctor neque. Amet venenatis urna cursus eget nunc scelerisque. Quis imperdiet massa tincidunt nunc pulvinar sapien et. Risus feugiat in ante metus dictum. Sit amet massa vitae tortor condimentum lacinia quis vel eros. Orci ac auctor augue mauris augue neque gravida.

Sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper. Quis varius quam quisque id diam vel. A erat nam at lectus urna duis. A pellentesque sit amet porttitor. Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Vivamus at augue eget arcu dictum varius duis at consectetur. In est ante in nibh mauris cursus mattis molestie. Sed id semper risus in hendrerit. Ac odio tempor orci dapibus ultrices in. Aliquet porttitor lacus luctus accumsan tortor. Quis auctor elit sed vulputate mi sit amet. Ornare quam viverra orci sagittis eu. Porta nibh venenatis cras sed felis. Tempor id eu nisl nunc mi ipsum. Eget gravida cum sociis natoque penatibus. Massa eget egestas purus viverra accumsan in nisl. Purus faucibus ornare suspendisse sed nisi lacus sed viverra tellus. Nulla at volutpat diam ut venenatis tellus in. Mauris vitae ultricies leo integer malesuada nunc vel risus commodo. Consequat nisl vel pretium lectus quam id leo in.

Platea dictumst quisque sagittis purus sit amet. Adipiscing elit pellentesque habitant morbi tristique. Ut pharetra sit amet aliquam id diam maecenas ultricies mi. Nunc sed augue lacus viverra vitae congue. Etiam dignissim diam quis enim lobortis scelerisque fermentum dui. In fermentum posuere urna nec tincidunt praesent. Tristique senectus et netus et. Est ante in nibh mauris cursus. Lobortis elementum nibh tellus molestie nunc. Vitae nunc sed velit dignissim sodales ut eu. Dui nunc mattis enim ut tellus elementum. Pellentesque elit eget gravida cum sociis natoque. Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus.

Pulvinar pellentesque habitant morbi tristique senectus et netus et malesuada. Viverra ipsum nunc aliquet bibendum enim facilisis gravida neque. Ultrices eros in cursus turpis massa tincidunt dui. Amet mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Etiam non quam lacus suspendisse faucibus interdum. Ullamcorper malesuada proin libero nunc. Tellus mauris a diam maecenas sed enim ut sem. Malesuada bibendum arcu vitae elementum curabitur. Sed turpis tincidunt id aliquet risus. Tortor at auctor urna nunc id cursus metus aliquam. Justo eget magna fermentum iaculis eu non diam phasellus.

Libero justo laoreet sit amet cursus. Vitae congue eu consequat ac. Sagittis vitae et leo duis ut diam quam nulla. Augue interdum velit euismod in pellentesque massa placerat duis ultricies. Sit amet facilisis magna etiam tempor. Sit amet mattis vulputate enim nulla. Hendrerit dolor magna eget est lorem ipsum dolor. Mauris pharetra et ultrices neque ornare. Massa tempor nec feugiat nisl pretium fusce id velit ut. Sapien et ligula ullamcorper malesuada proin libero nunc consequat interdum. Elementum integer enim neque volutpat ac tincidunt vitae semper. Libero volutpat sed cras ornare arcu dui vivamus arcu felis. Est ante in nibh mauris cursus mattis molestie a.

Mattis pellentesque id nibh tortor id. Nulla pharetra diam sit amet nisl suscipit adipiscing bibendum est. Mauris augue neque gravida in fermentum et sollicitudin. Bibendum enim facilisis gravida neque convallis. Eget magna fermentum iaculis eu non diam phasellus vestibulum lorem. Venenatis urna cursus eget nunc scelerisque viverra mauris in. Pharetra pharetra massa massa ultricies mi. Rhoncus urna neque viverra justo nec ultrices dui. Sit amet venenatis urna cursus eget. Tincidunt vitae semper quis lectus nulla at. Pharetra magna ac placerat vestibulum lectus mauris ultrices eros. Feugiat in ante metus dictum at tempor commodo ullamcorper. Interdum varius sit amet mattis vulputate enim nulla aliquet.

Maecenas pharetra convallis posuere morbi leo urna molestie at. Vulputate enim nulla aliquet porttitor. Ipsum dolor sit amet consectetur adipiscing elit duis tristique. Nec feugiat nisl pretium fusce id. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Iaculis urna id volutpat lacus laoreet non curabitur. Non blandit massa enim nec dui nunc. Dui ut ornare lectus sit amet est placerat in egestas. Sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum. Viverra aliquet eget sit amet tellus cras. Senectus et netus et malesuada. Gravida arcu ac tortor dignissim convallis aenean et tortor at. Ultrices dui sapien eget mi proin sed libero enim. Volutpat consequat mauris nunc congue nisi vitae suscipit tellus. Pulvinar etiam non quam lacus suspendisse faucibus. Lacus laoreet non curabitur gravida arcu ac. Diam maecenas sed enim ut sem viverra aliquet eget sit. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu. Ut lectus arcu bibendum at varius vel.
        *
        * */

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AjustesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AjustesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}