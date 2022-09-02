SUMMARY = "Your Hardcore Loop Machine"
LICENSE = "GPL-3.0-only"
# for juce
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " \
    gitsm://github.com/monocasual/giada.git;protocol=https;branch=master \
    file://0001-Hack-juceaide-build-to-native-paths.patch \
    file://0002-Do-not-log-API-not-available.patch \
"
SRCREV = "a4aca0d1c42ae1fb60b3e8854a558c3e0e5d2720"
S = "${WORKDIR}/git"
PV = "0.22.0"

inherit cmake pkgconfig features_check gtk-icon-cache

REQUIRED_DISTRO_FEATURES ?= "x11"

DEPENDS += " \
    fltk fltk-native \
    freetype-native \
    libxinerama \
    libxpm \
    alsa-lib \
    jack \
    pulseaudio \
    libsndfile1 \
    libsamplerate0 \
    rtmidi \
    fmt \
    nlohmann-json \
"
# vst2 headers are missing (no GPL??)
EXTRA_OECMAKE = " \
    -DWITH_ALSA=ON \
    -DWITH_PULSE=ON \
    -DWITH_JACK=ON \
    -DWITH_VST2=OFF \
    -DWITH_VST3=ON \
"

do_install:append() {
    rm -rf ${D}${bindir}/JUCE-*
    rm -rf ${D}${includedir}/JUCE-*
    rm -rf ${D}${libdir}/cmake
    rmdir --ignore-fail-on-non-empty ${D}${libdir}
}

# For src/utils/log.h: print (revisit?)
SECURITY_STRINGFORMAT = ""


FILES:${PN}:append = " \
    ${datadir}/metainfo \
"
