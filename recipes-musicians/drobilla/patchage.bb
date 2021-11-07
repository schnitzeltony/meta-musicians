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
    gitsm://gitlab.com/drobilla/patchage.git;protocol=https;branch=master \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "34f5d891fabe5c4e6137ce3d94aee8ca1955ebab"
PV = "1.0.4"
S = "${WORKDIR}/git"
