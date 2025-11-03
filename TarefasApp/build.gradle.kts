// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.4.1" apply false // A versão pode variar
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false // A versão pode variar
    id("androidx.room") version "2.6.1" apply false // <--- ADICIONE ESTA LINHA
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false
}
