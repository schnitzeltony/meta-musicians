SUMMARY = "Qt based DJ software"
HOMEPAGE = "http://mixxx.org/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b3ce5d18079fa79804cd62469a51d176"

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

SRC_URI = "git://github.com/mixxxdj/${BPN}.git;branch=main;protocol=https"
SRCREV = "96fc5dd217a81d0e2327a52f564f7aea7d5c2c43"
S = "${WORKDIR}/git"
PV = "2.3.2"

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
