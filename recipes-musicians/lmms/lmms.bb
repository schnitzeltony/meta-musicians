require ${BPN}.inc

inherit cmake_qt5 distro_features_check pkgconfig mime gtk-icon-cache pkgconfig bash-completion

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI += " \
    file://0001-Find-native-bin2res.patch \
    file://0002-zynaddsubfx-link-agains-X11.patch \
    file://0003-CMake-3rdparty-Do-not-overwrite-CMAKE_C-XX-_FLAGS.patch \
    file://0004-carlabase-Do-not-add-RPATH-to-carlabase.patch \
"

DEPENDS += " \
    ${BPN}-native \
    qtbase \
    qttools-native \
    qtx11extras \
    jack \
    fftw \
    stk \
    lame \
    fluidsynth \
    portaudio-v19 \
    libsdl \
    carla \
    fltk fltk-native \
"

CXXFLAGS += "-fpermissive"

EXTRA_OECMAKE += " \
    -DWANT_QT5=ON \
    -DWANT_WEAKJACK=OFF \
"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/menu \
"

RDEPENDS_${PN} += "carla"
