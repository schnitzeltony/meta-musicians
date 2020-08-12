SUMMARY = "A free software percussion synthesizer"
HOMEPAGE = "https://gitlab.com/iurie-sw/geonkick"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit cmake mime mime-xdg gtk-icon-cache

DEPENDS += " \
    redkite \
    redkite-native \
    libsndfile1 \
    rapidjson \
    jack \
    lv2 \
"

SRC_URI = "git://gitlab.com/iurie-sw/geonkick;protocol=https"
SRCREV = "4c327b4712a2a2bfb18c5eda46490d143b5b3aa3"
PV = "2.3.4"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
    -DGKICK_ARCHITECTURE=${TARGET_ARCH} \
"

FILES_${PN} += " \
    ${datadir}/mime \
    ${libdir}/lv2 \
"
