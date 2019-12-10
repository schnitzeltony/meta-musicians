SUMMARY = "Patchage is a modular patch bay for audio and MIDI systems"
DESCRIPTION = "Patchage is a modular patch bay for audio and MIDI systems based on Jack and Alsa"
HOMEPAGE = "http://drobilla.net/software/patchage"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf gtk-icon-cache pkgconfig

DEPENDS += " \
    boost \
    jack \
    ganv \
"

SRC_URI = " \
    gitsm://gitlab.com/drobilla/patchage.git;protocol=https \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "0a175df57e8d55d67a8b5fe8308f35dd895b91cf"
PV = "1.0.1+git${SRCPV}"
S = "${WORKDIR}/git"
