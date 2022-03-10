SUMMARY = "ZToolkit (Ztk) is a cross-platform GUI toolkit"
HOMEPAGE = "https://www.zrythm.org/"
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb1e647870add0502f8f010b19de32af"

inherit meson gettext features_check

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    git://git.zrythm.org/git/ztoolkit;protocol=https;branch=master \
    file://0001-Remove-tests-from-builds-they-cause-linker-errors.patch \
"
SRCREV = "be7370d0926c5d676a32b9742b6e33c879a25f3b"
PV = "0.1.1"
S = "${WORKDIR}/git"


DEPENDS = " \
    virtual/libx11 \
    cairo \
"

PACKAGECONFIG ??= "rsvg"
PACKAGECONFIG[rsvg] = "-Denable_rsvg=true,-Denable_rsvg=false,librsvg"
