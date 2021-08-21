SUMMARY = "Your Hardcore Loop Machine"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "gitsm://github.com/monocasual/giada.git;protocol=https"
SRCREV = "1eaf3d5e5f9f017b6cb5ab29ed141c2cf232d1a3"
S = "${WORKDIR}/git"
PV = "0.18.1"

inherit cmake features_check gtk-icon-cache

REQUIRED_DISTRO_FEATURES ?= "x11"

DEPENDS += " \
    fltk fltk-native \
    libxinerama \
    libxpm \
    alsa-lib \
    jack \
    pulseaudio \
    libsndfile1 \
    libsamplerate0 \
    rtmidi \
"
# vst2 headers are missing (no GPL??)
EXTRA_OECMAKE = " \
    -DWITH_ALSA=ON \
    -DWITH_PULSE=ON \
    -DWITH_JACK=ON \
    -DWITH_VST2=OFF \
    -DWITH_VST3=ON \
"
# For src/utils/log.h: print (revisit?)
SECURITY_STRINGFORMAT = ""

FILES:${PN}:append = " \
    ${datadir}/metainfo \
"
