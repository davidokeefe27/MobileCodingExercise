package com.example.mobilecodingexercise.comicDetail

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.mobilecodingexercise.databinding.FragmentComicDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComicDetailFragment : Fragment() {

    private lateinit var binding: FragmentComicDetailBinding

    private val viewModel: ComicDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchInfo()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.comicDetails.collect{
                    binding.title.text = it?.title.orEmpty()
                    binding.summary.text = it?.summary.orEmpty()

                    Glide.with(binding.root)
                        .load(it?.coverImg)
                        .into(binding.itemDetailHeader.comicCover)

                    Glide.with(binding.root)
                        .load(it?.coverImg)
                        .transform(BlurTransformation())
                        .into(object : CustomTarget<Drawable>(){
                            override fun onResourceReady(
                                resource: Drawable,
                                transition: Transition<in Drawable>?
                            ) {
                                binding.itemDetailHeader.root.background = resource
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {

                            }

                        }
                        )
                }
            }
        }
    }
}