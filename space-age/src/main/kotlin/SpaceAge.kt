class SpaceAge(age: Long) {
    val seconds = age

    val SECONDS_EARTH = 31557600.0
    val SECONDS_MERCURY = SECONDS_EARTH * 0.2408467
    val SECONDS_VENUS = SECONDS_EARTH * 0.61519726
    val SECONDS_MARS = SECONDS_EARTH * 1.8808158
    val SECONDS_JUPITER = SECONDS_EARTH * 11.862615
    val SECONDS_SATURN = SECONDS_EARTH * 29.447498
    val SECONDS_URANUS = SECONDS_EARTH * 84.016846
    val SECONDS_NEPTUNE = SECONDS_EARTH * 164.79132

    fun onEarth() = computeSpaceAge(SECONDS_EARTH)
    fun onMercury() = computeSpaceAge(SECONDS_MERCURY)
    fun onVenus() = computeSpaceAge(SECONDS_VENUS)
    fun onMars() = computeSpaceAge(SECONDS_MARS)
    fun onJupiter() = computeSpaceAge(SECONDS_JUPITER)
    fun onSaturn() = computeSpaceAge(SECONDS_SATURN)
    fun onUranus() = computeSpaceAge(SECONDS_URANUS)
    fun onNeptune() = computeSpaceAge(SECONDS_NEPTUNE)

    private fun computeSpaceAge(planetSeconds: Double) = (seconds / planetSeconds).roundToTwoDigits()
    private fun Double.roundToTwoDigits() = Math.round(this * 100.0) / 100.0
}