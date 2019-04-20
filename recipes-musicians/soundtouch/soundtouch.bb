SUMMARY = "SoundTouch audio tempo/pitch control library"
HOMEPAGE = "http://www.surina.net/soundtouch/index.html"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.TXT;md5=4d2892adf339c4489918ab705d44f66c"

inherit autotools-brokensep pkgconfig gettext

SRC_URI = " \
    git://gitlab.com/${BPN}/${BPN}.git \
    file://0001-Fix-path-to-m4-macro-dir.patch \
"
SRCREV = "9205fc971ed23cff407a67242bb9036a51113af4"
PV = "2.1.2"
S = "${WORKDIR}/git"
