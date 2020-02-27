SUMMARY = "MusE is a digital audio workstation"
HOMEPAGE = "http://muse-sequencer.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://muse3/COPYING;md5=328283dc167a7b37ffdc59f524a7fc4d"

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

SRC_URI = " \
    git://github.com/muse-sequencer/muse.git \
    file://0001-Do-not-try-to-find-aeffectx.h-it-is-not-found-for-un.patch \
    file://0002-muse-find-unused-wavs-convert-to-pythomn3.patch \
"
SRCREV = "50f4b71eab801aa49f35b66fdfdca9ab02e08238"
PV = "3.1.0"
S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH = "${S}/muse3"

EXTRA_OECMAKE += " \
    -DLIB_INSTALL_DIR=${libdir} \
    -DMODULES_BUILD_STATIC=1 \
    -DCMAKE_SHARED_LINKER_FLAGS=-Wl,--no-undefined \
    -DVST_HEADER_PATH=${S}/muse3/vestige \
    -DENABLE_VST_VESTIGE=1 \
    \
    -DENABLE_LV2=1 \
    -DENABLE_DSSI=1 \
    -DENABLE_FLUID=1 \
    -DENABLE_VST_NATIVE=1 \
"
#    -DENABLE_EXPERIMENTAL=1 won't work


do_install_append() {
    # remove python script to convert songs from very old muse to avoid
    # python rdeps
    rm -f ${D}${datadir}/muse-3.1/utils/muse-song-convert.py
}

QT_TRANSLATION_FILES = "${datadir}/*/locale/*.qm"
FILES_${PN}-locale = "${datadir}/muse-3.0/locale"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
    ${datadir}/muse-3.1 \
    ${libdir}/muse-3.1 \
"

RDEPENDS_${PN} += "python3-core"
