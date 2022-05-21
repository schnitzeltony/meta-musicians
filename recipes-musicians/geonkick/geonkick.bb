SUMMARY = "A free software percussion synthesizer"
HOMEPAGE = "https://gitlab.com/iurie-sw/geonkick"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit cmake pkgconfig mime mime-xdg gtk-icon-cache

DEPENDS += " \
    libsndfile1 \
    rapidjson \
    jack \
    lv2 \
"

SRC_URI = "git://gitlab.com/iurie-sw/geonkick;protocol=https;branch=main"
SRCREV = "ce95f97363de78cc0cc0f0830f965ecced59195d"
PV = "2.9.1"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
    -DGKICK_ARCHITECTURE=${TARGET_ARCH} \
"

FILES:${PN} += " \
    ${datadir}/mime \
    ${libdir}/lv2 \
"
