SUMMARY = "Qt based DJ software"
HOMEPAGE = "http://mixxx.org/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e5323335634095f8bdd15f6a5c5c5865"

inherit cmake_qt5 gtk-icon-cache features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    qtbase \
    qtscript \
    qtsvg \
    qtxmlpatterns \
    qtx11extras \
    qtkeychain \
    qttools-native \
    libusb1 \
    hidapi \
    upower \
    sqlite3 \
    libid3tag \
    taglib \
    libmad \
    faad2 \
    libmp4v2 \
    libogg \
    libvorbis \
    protobuf protobuf-native \
    fftw \
    portaudio-v19 \
    portmidi \
    chromaprint \
    rubberband \
    soundtouch \
    libglu \
    lilv \
    lame \
    wavpack \
    libmodplug \
    libkeyfinder \
    libebur128 \
"
# causes segfault trying to find debug libs
#    gperftools

SRC_URI = " \
    git://github.com/mixxxdj/${BPN}.git;branch=main;protocol=https \
"
SRCREV = "8acb633220024222504cddcd1f5ea26e659fbcc7"
S = "${WORKDIR}/git"
PV = "2.3.1"

EXTRA_OECMAKE += " \
    -DSHOUTCAST=OFF \
    -DLOCALECOMPARE=OFF \
    -DFAAD=ON \
"
#    -DPERFTOOLS=ON

FILES:${PN} += " \
    ${datadir}/appdata \
    ${datadir}/metainfo \
"
