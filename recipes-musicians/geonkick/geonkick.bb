SUMMARY = "A free software percussion synthesizer"
HOMEPAGE = "https://gitlab.com/iurie-sw/geonkick"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit cmake mime mime-xdg gtk-icon-cache

DEPENDS += " \
    redkite-native \
    libsndfile1 \
    rapidjson \
    jack \
    lv2 \
"

SRC_URI = " \
    git://gitlab.com/iurie-sw/geonkick;protocol=https \
    file://0001-Execute-native-REDKITE-S-rkpng2c.patch \
"
SRCREV = "77b2155f8b30ea7e4af5c664e930eeb43c17a24d"
PV = "2.7.3"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
    -DGKICK_ARCHITECTURE=${TARGET_ARCH} \
"

FILES:${PN} += " \
    ${datadir}/mime \
    ${libdir}/lv2 \
"
