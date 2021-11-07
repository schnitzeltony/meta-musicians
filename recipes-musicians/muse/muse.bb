SUMMARY = "MusE is a digital audio workstation"
HOMEPAGE = "http://muse-sequencer.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://src/COPYING;md5=328283dc167a7b37ffdc59f524a7fc4d"

DEPENDS += " \
    qtbase \
    qttools qttools-native \
    qtsvg \
    jack \
    liblo \
    dssi \
    gtkmm \
    fluidsynth \
    serd \
    lilv \
    lv2 \
    harfbuzz \
    rubberband \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache features_check mime qt5-translation mime-xdg

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    git://github.com/muse-sequencer/muse.git;branch=master;protocol=https \
    file://0001-Do-not-try-to-find-aeffectx.h-it-is-not-found-for-un.patch \
    file://0002-muse-find-unused-wavs-convert-to-pythomn3.patch \
"
SRCREV = "3e79cbcbea4480a43dc6052fb0fc118c356fb404"
PV = "4.0.0"
S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH = "${S}/src"

EXTRA_OECMAKE += " \
    -DLIB_INSTALL_DIR=${libdir} \
    -DMODULES_BUILD_STATIC=1 \
    -DCMAKE_SHARED_LINKER_FLAGS='${LDFLAGS} -Wl,--no-undefined' \
    -DVST_HEADER_PATH=${S}/src/vestige \
    -DENABLE_VST_VESTIGE=1 \
    \
    -DENABLE_LV2=1 \
    -DENABLE_DSSI=1 \
    -DENABLE_FLUID=1 \
    -DENABLE_VST_NATIVE=1 \
"
#    -DENABLE_EXPERIMENTAL=1 won't work


do_install:append() {
    # remove python script to convert songs from very old muse to avoid
    # python rdeps
    rm -f ${D}${datadir}/muse-4.0/utils/muse-song-convert.py
}

QT_TRANSLATION_FILES = "${datadir}/*/locale/*.qm"
FILES:${PN}-locale = "${datadir}/muse-3.0/locale"

FILES:${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/muse-4.0 \
    ${libdir}/muse-4.0 \
"

RDEPENDS:${PN} += "python3-core"
