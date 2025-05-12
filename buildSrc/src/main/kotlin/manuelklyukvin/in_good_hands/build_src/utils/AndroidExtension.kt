package manuelklyukvin.in_good_hands.build_src.utils

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project

internal fun Project.android() = extensions.getByType(LibraryExtension::class.java)